#!/bin/bash

file_path="demo/request/example-invalid.json"

response=$(curl -X POST -H "Content-Type: application/json" -d "@$file_path" -s http://localhost:8080/api/v1/vehicle-logs/search)

echo "Response status code: $response"
