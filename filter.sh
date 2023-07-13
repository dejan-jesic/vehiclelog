#!/bin/bash

read -r -p "Which file do you want to use for search? (1 or 2): " file_input

if [ "$file_input" = "1" ]; then
  file_path="demo/request/example-1.json"
elif [ "$file_input" = "2" ]; then
  file_path="demo/request/example-2.json"
else
  echo "Invalid input."
  exit
fi

echo "Search request:"
cat "$file_path"

response=$(curl -X POST -H "Content-Type: application/json" -d "@$file_path" -s http://localhost:8080/api/v1/vehicle-logs/search)

echo "\nResponse: "
echo "$response"
