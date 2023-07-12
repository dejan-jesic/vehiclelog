package com.logineko.vehiclelog.web;

import com.logineko.vehiclelog.persistance.model.VehicleLog;
import com.logineko.vehiclelog.web.search.VehicleLogSearchDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface VehicleLogControllerDocs {

    @Operation(summary = "Dynamic search for vehicles.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Fetch vehicles.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Operation not applicable for the given type.",
                    content = @Content(mediaType = "application/json")
            )
    })
    Page<VehicleLog> advancedSearch(@RequestBody final VehicleLogSearchDTO searchDTO, final Pageable pageable);

    @Operation(summary = "Uploads .csv file.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Uploads file successfully."
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "File is not in supported format.",
                    content = @Content(mediaType = "application/json")
            )
    })
    void uploadCSV(final MultipartFile file);

}
