#!/bin/bash

read -r "Which file do you want to use for search? (1 or 2): " file_input

if [ "$file_input" = "1" ]; then
  file_path="./search-1.json"
elif [ "$file_input" = "2" ]; then
  file_path="./search-2.json"
else
  echo "Invalid input. Exiting."
  exit
fi

if [ ! -f "$file_path" ]; then
  echo "File not found: $file_path. Exiting."
  exit
fi

response=$(curl -X POST -d "@$file_path" -s http://localhost:8000/api/v1/vehicle-logs/search)

echo "Response: "
echo "$response"
