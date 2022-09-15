package com.alkemy.disney.exception;

public enum EnumErrors {
        ID_MOVIE ("ID movie not found"),
        ID_CHARACTER ("ID character not found"),
        PARAM ("Param not found"),
        CHARACTER_IN_MOVIE("Movie already contain this Character"),
        INVALID_METHOD("Invalid method for this path"),
        USER_ALREADY_EXIST("User already exist"),
        WRONG_CREDENTIALS("Wrong user or password");

        private String errorMessage;

        EnumErrors(String message){
            this.errorMessage= message;
        }

        public String getErrorMessage(){return errorMessage;}

}
