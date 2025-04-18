package com.cargocompare.CargoCompare_api.user;

import com.cargocompare.CargoCompare_api.commons.constants.ApiVersion;
import com.cargocompare.CargoCompare_api.user.dto.UserDTO;
import com.cargocompare.CargoCompare_api.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

        @GetMapping("/{id}")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public ResponseEntity<UserDTO> getUserById(@PathVariable UUID id) {
            return ResponseEntity.ok(userService.getUserById(id));
        }

        @PutMapping("/{id}")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public ResponseEntity<UserDTO> updateUser(
                @PathVariable UUID id,
                @RequestBody UserDTO userDTO
        ) {
            return ResponseEntity.ok(userService.updateUser(id, userDTO));
        }

        @DeleteMapping("/{id}")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
}
