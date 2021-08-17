package dev.highright96.validation.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    @Override
    public void initialize(YearMonth yearMonth) {
        pattern = yearMonth.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            LocalDate.parse(value, DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
