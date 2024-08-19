package br.com.fiap.apinextgen.dto;

import br.com.fiap.apinextgen.model.User;

public record UserResponse(
        Long id,
        String name,
        String gender,
        Boolean aged
) {

    public static UserResponse fromModel(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getGender(), user.isAged());
    }

}
