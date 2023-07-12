#!/bin/sh

echo "Uploading files..."

upload_url="http://localhost:8080/api/v1/vehicle-logs/upload"
csv_files=(
  "LD_A5304997_20230331_20230401.csv"
  "LD_A5305041_20230330_20230331.csv"
  "LD_C7502627_20221007_20221008.csv"
  "LD_C7502643_20221114_20221115.csv"
)

for file in "${csv_files[@]}"; do
  response=$(curl -X POST -F "file=@$file" -s -w "\n%{http_code}" $upload_url)
  status_code=$(echo "$response" | tail -n 1)

  if [ "$status_code" -eq 200 ]; then
    echo "Successfully uploaded $file!"
  fi
done
