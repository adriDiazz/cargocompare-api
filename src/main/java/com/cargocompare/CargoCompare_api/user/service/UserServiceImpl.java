package com.cargocompare.CargoCompare_api.user.service;

import com.cargocompare.CargoCompare_api.user.User;
import com.cargocompare.CargoCompare_api.user.UserRepository;
import com.cargocompare.CargoCompare_api.user.dto.UserDTO;
import com.cargocompare.CargoCompare_api.user.dto.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User not found")
        );
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    @Override
    public UserDTO getUserById(UUID id) {
        return userRepository.findById(id)
                .map(UserMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserDTO updateUser(UUID id, UserDTO userDTO) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(userDTO.getName());
                    user.setEmail(userDTO.getEmail());
                    user.setLastName(userDTO.getLastName());
                    user.setState(userDTO.getState());

//                    user.setRole(userDTO.getRole());

                    return UserMapper.toDTO(userRepository.save(user));
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void deleteUser(UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
