package rvt.utils;

public enum ConsoleColors {
    RED("\u001B[31m"), 
    YELLOW_BACKGROUND("\u001B[43m"), 
    COLOR_END("\\u001B[0m");

    final String code;
    ConsoleColors(String code) {
        this.code = code;
    }
}
