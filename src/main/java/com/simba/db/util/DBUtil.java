package com.simba.db.util;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    /**
     * Generate SQL insert statement for a object
     * @param o
     * @return
     */
    public static String generateInsertSQL(Object o){
        StringBuffer insertSQL = new StringBuffer("INSERT INTO ");
        Class clazz = o.getClass();
        //Get table name
        String tableName;
        if(clazz.isAnnotationPresent(Table.class)){
            Table table = (Table)clazz.getAnnotation(Table.class);
            tableName = table.name();
        } else{
            tableName = clazz.getSimpleName();
        }
        //Get column names
        insertSQL.append(tableName).append(" (");
        Field[] fields = clazz.getDeclaredFields();
        List<Object> params = new ArrayList<Object>();
        for (Field field: fields) {
            if(field.isAnnotationPresent(Column.class)){
                Column column = field.getAnnotation(Column.class);
                try {
                    field.setAccessible(true);
                    Object fieldValue = field.get(o);
                    if(fieldValue == null){
                        continue;
                    }
                    if(params.size() != 0){
                        insertSQL.append(",");
                    }
                    if(column.name() != null) {
                        insertSQL.append(column.name());
                    } else {
                        insertSQL.append(field.getName());
                    }
                    params.add(fieldValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        insertSQL.append(") values (");
        //handle values
        for(int i=0; i < params.size(); i++){
            if(i != 0){
                insertSQL.append(",");
            }
            insertSQL.append("?");
        }
        insertSQL.append(")");
        return insertSQL.toString();
    }
    public static String generateUpdateSQL(Object o) throws Exception {
        StringBuffer updateSQL = new StringBuffer("UPDATE ");
        Class clazz = o.getClass();
        String tableName;
        if(clazz.isAnnotationPresent(Table.class)){
            Table table = (Table)clazz.getAnnotation(Table.class);
            tableName = table.name();
        } else{
            tableName = clazz.getSimpleName();
        }
        updateSQL.append(tableName);

        Field[] fields = clazz.getDeclaredFields();
        List<Object> params = new ArrayList<Object>();
        String idColumn = null;
        Object idValue = null;
        for (Field field: fields) {
            if(field.isAnnotationPresent(Column.class)){
                Column column = field.getAnnotation(Column.class);
                try {
                    field.setAccessible(true);
                    Object fieldValue = field.get(o);
                    if(fieldValue == null){
                        continue;
                    }
                    if(field.isAnnotationPresent(Id.class)){
                        idColumn = column.name() == null ? field.getName():column.name();
                        idValue = fieldValue;
                        continue;
                    }
                    if(params.size() != 0){
                        updateSQL.append(",");
                    } else {
                        updateSQL.append(" set ");
                    }
                    if(column.name() != null) {
                        updateSQL.append(column.name());
                    } else {
                        updateSQL.append(field.getName());
                    }
                    updateSQL.append(" = ? ");
                    params.add(fieldValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        updateSQL.append("where ");
        if(idColumn == null || idValue == null){
            throw new Exception("Can't get Id column or value from this domain object.");
        }
        updateSQL.append(idColumn).append(" = ? ");
        params.add(idValue);
        return updateSQL.toString();
    }

}
