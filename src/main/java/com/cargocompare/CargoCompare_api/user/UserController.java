package com.cargocompare.CargoCompare_api.user;

import com.cargocompare.CargoCompare_api.commons.constants.ApiVersion;
import com.cargocompare.CargoCompare_api.user.dto.UserDTO;
import com.cargocompare.CargoCompare_api.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiVersion.API_PATH + "/users")
public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

         @GetMapping("/")
         @PreAuthorize("hasRole('ROLE_ADMIN')")
         public ResponseEntity<List<UserDTO>> getAllUsers() {
             return ResponseEntity.ok(userService.getAllUsers());
         }
}
