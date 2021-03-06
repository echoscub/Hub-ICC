package net.scub.hubicc.batch.tools.csv.converter;

import com.opencsv.bean.AbstractBeanField;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class DateYearConverter extends AbstractBeanField<Date> {

    @Override
    protected Object convert(String value) {
        return Optional.ofNullable(value)
                .filter(StringUtils::isNoneEmpty)
                .map(String::trim)
                .map(String::toLowerCase)
                .map(item -> {
                    try {
                        return new SimpleDateFormat("YYYY").parse(item);
                    } catch (ParseException e) {
                        System.out.println("unsupported date with pattern YYYY : " + item);
                        return null;
                    }
                }).orElse(null);
    }
}
