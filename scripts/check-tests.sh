#!/usr/bin/env bash
# Fails if any started exercise (a module with Java code in src/main/java)
# has no unit tests. Shop-model is excluded: its tests live in exercise 5.4.
set -euo pipefail
cd "$(dirname "$0")/.."

missing=()
while IFS= read -r pom; do
  module="$(dirname "$pom")"
  [[ "$module" == "." || "$module" == *"/shop-model" ]] && continue
  if [[ -d "$module/src/main/java" ]] && find "$module/src/main/java" -name '*.java' | grep -q .; then
    if ! grep -rqE '@([A-Za-z_.]+\.)?(Test|ParameterizedTest|RepeatedTest|TestFactory)\b' "$module/src/test/java" --include='*.java' 2>/dev/null; then
      missing+=("$module")
    fi
  fi
done < <(find . -name pom.xml -not -path '*/target/*' | sed 's|^\./||' | sort)

if (( ${#missing[@]} > 0 )); then
  echo "These exercises have code but no unit tests:"
  printf '  - %s\n' "${missing[@]}"
  exit 1
fi
echo "Every started exercise has unit tests."
