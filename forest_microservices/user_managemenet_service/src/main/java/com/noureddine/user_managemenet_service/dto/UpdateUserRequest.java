package com.noureddine.user_managemenet_service.dto;



import com.noureddine.commonlibrary.model.Profile;
import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateUserRequest {



    @Nullable
    private Profile profile;


    @Nullable
    private String password;
}
