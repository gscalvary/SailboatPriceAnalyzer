package sailboatPriceAnalyzer.domain.factories;

import org.springframework.stereotype.Component;
import sailboatPriceAnalyzer.domain.valueObjects.SailboatData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MakeByLengthByYearFactory {

    public Map<String, Map<Float, Map<Integer, Float>>> build (List<SailboatData> sailboatData) {

        Map<String, Map<Float, Map<Integer, Float>>> makeByLengthByYear = new HashMap<>();
        Map<String, Integer> numberEntries = new HashMap<>();

        for (SailboatData sailboatDatum : sailboatData) {

            String make = sailboatDatum.getMake();
            Float length = sailboatDatum.getLength();
            Integer year = sailboatDatum.getYear();
            float price = sailboatDatum.getPrice();

            if (!makeByLengthByYear.containsKey(make))
            {
                makeByLengthByYear.put(make, new HashMap<>());
            }

            if (!makeByLengthByYear.get(make).containsKey(length)) {
                makeByLengthByYear.get(make).put(length, new HashMap<>());
            }

            if (!makeByLengthByYear.get(make).get(length).containsKey(year)) {
                makeByLengthByYear.get(make).get(length).put(year, 0f);
            }

            String numberEntriesKey = make + length + year;

            if (!numberEntries.containsKey(numberEntriesKey)) {
                numberEntries.put(numberEntriesKey, 0);
            }

            int numberEntriesValue = numberEntries.get(numberEntriesKey) + 1;
            numberEntries.put(numberEntriesKey, numberEntriesValue);

            float averagePrice = (makeByLengthByYear.get(make).get(length).get(year) + price) / numberEntriesValue;
            makeByLengthByYear.get(make).get(length).put(year, averagePrice);
        }

        return makeByLengthByYear;
    }
}
