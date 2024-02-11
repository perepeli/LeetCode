package problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignSQL {
    Map<String, Table> database = new HashMap<>();

    public DesignSQL(List<String> names, List<Integer> columns) {

        for(int i = 0; i < names.size(); i++) {
            database.put(names.get(i), new Table(columns.get(i)));
        }
    }

    public void insertRow(String name, List<String> row) {
        database.get(name).insert(row);
    }

    public void deleteRow(String name, int rowId) {
        database.get(name).delete(rowId);
    }

    public String selectCell(String name, int rowId, int columnId) {
        return database.get(name).select(rowId, columnId);
    }

    static class Table {
        int sequence = 1;
        int columns;
        Map<Integer, List<String>> rows = new HashMap<>();

        public Table(int columns) {
            this.columns = columns;
        }

        public void insert(List<String> row) {
            if(row.size() > columns) return;
            rows.put(sequence, row);
            sequence++;
        }

        public void delete(int rowId) {
            rows.remove(rowId);
        }

        public String select(int rowId, int columnId) {
            if(rows.containsKey(rowId)) {
                return rows.get(rowId).get(columnId - 1);
            }
            return null;
        }
    }
}
