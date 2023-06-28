package com.boris.stuff_members.dto;

import com.boris.stuff_members.entity.Worker;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkerClientDto {
    private Long id;
    private String firstName = "name";
    private String lastName = "lastname";
    private String middleName = "middlename";
    private String email = "email";
    private String phone = "phone";
    private String personalId = "personal Id";
    private String role = "role";
    private Date startingDate;
    private String gender = "gender";

    public static class Builder {
        private Long id;
        private String firstName = "name";
        private String lastName = "lastname";
        private String middleName = "middlename";
        private String email = "email";
        private String phone = "phone";
        private String personalId = "personal Id";
        private String role = "role";
        private Date startingDate;
        private String gender = "gender";

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder personalId(String personalId) {
            this.personalId = personalId;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder startingDate(Date startingDate) {
            this.startingDate = startingDate;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public WorkerClientDto build() {
            WorkerClientDto workerClientDto = new WorkerClientDto();
            workerClientDto.firstName = this.firstName;
            workerClientDto.lastName = this.lastName;
            workerClientDto.middleName = this.middleName;
            workerClientDto.email = this.email;
            workerClientDto.phone = this.phone;
            workerClientDto.personalId = this.personalId;
            workerClientDto.role = this.role;
            workerClientDto.startingDate = this.startingDate;
            workerClientDto.gender = this.gender;
            return workerClientDto;
        }
    }
}
