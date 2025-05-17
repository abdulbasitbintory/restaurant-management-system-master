package restaurantsystem.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import restaurantsystem.model.Labour;

public class LabourService {
    private static final String LABOUR_FILE = "storage/labour.txt";
    private static final String DELIMITER = ",";

    public List<Labour> getAll() {
        try {
            if (!Files.exists(Paths.get(LABOUR_FILE))) {
                Files.createDirectories(Paths.get("storage"));
                Files.createFile(Paths.get(LABOUR_FILE));
                return new ArrayList<>();
            }

            return Files.lines(Paths.get(LABOUR_FILE))
                    .map(this::parseLabour)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read labour data", e);
        }
    }

    public void create(Labour labour) {
        try {
            String labourRecord = String.join(DELIMITER,
                    labour.getId(),
                    labour.getName(),
                    String.valueOf(labour.getSalary()));

            Files.write(Paths.get(LABOUR_FILE),
                    (labourRecord + System.lineSeparator()).getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create labour record", e);
        }
    }

    public boolean update(String sourceId, Labour updatedLabour) {
        List<Labour> labourList = getAll();
        boolean updated = false;

        for (int i = 0; i < labourList.size(); i++) {
            if (labourList.get(i).getId().equalsIgnoreCase(sourceId)) {
                labourList.set(i, updatedLabour);
                updated = true;
                break;
            }
        }

        if (updated) {
            writeAllLabour(labourList);
        }
        return updated;
    }

    public boolean delete(String labourID) {
        List<Labour> labourList = getAll();
        boolean removed = labourList.removeIf(l -> l.getId().equalsIgnoreCase(labourID));

        if (removed) {
            writeAllLabour(labourList);
        }
        return removed;
    }

    private Labour parseLabour(String line) {
        String[] parts = line.split(DELIMITER);
        return new Labour(parts[0], parts[1], Double.parseDouble(parts[2]));
    }

    private void writeAllLabour(List<Labour> labourList) {
        try {
            String content = labourList.stream()
                    .map(l -> String.join(DELIMITER,
                            l.getId(),
                            l.getName(),
                            String.valueOf(l.getSalary())))
                    .collect(Collectors.joining(System.lineSeparator()));

            Files.write(Paths.get(LABOUR_FILE), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write labour data", e);
        }
    }
}