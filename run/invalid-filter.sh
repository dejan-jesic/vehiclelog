#!/bin/bash

file_path="request/invalid-search.json"

response=$(curl -X POST -d "@$file_path" -s http://localhost:8000/api/v1/vehicle-logs/search)

echo "Response: "
echo "$response"
