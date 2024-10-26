package ru.kolomiets;

import java.lang.reflect.Field;
import java.util.UUID;

public class QueryBuilder {
    public QueryBuilder() {
    }

    public String buildDeleteQuery(Class<?> clazz, UUID primaryKey) {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = (Table)clazz.getAnnotation(Table.class);
            query.append(tableAnnotation.name()).append(" WHERE ");
        }

        Field[] fields = clazz.getDeclaredFields();
        Field[] var5 = fields;
        int var6 = fields.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Field field = var5[var7];
            if (field.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = (Column)field.getAnnotation(Column.class);
                if (columnAnnotation.primaryKey()) {
                    query.append(columnAnnotation.name()).append(" = ").append(primaryKey);
                    break;
                }
            }
        }

        return query.toString();
    }
}
