package cn.hdj.annotations.SQLGenenator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成表注解处理器
 */
public class TableCreator {

    /**
     * @param args 是一个数组，传入的是类的权限类名
     * @throws ClassNotFoundException
     */
    public static void generator(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            System.out.println("arguments :annotation classes");
            System.exit(0);
        }
        for (String className : args) {
            //通过全限定类名，获取类
            Class<?> cl = Class.forName(className);
            //获取该类的DBTable注解
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            //如果没有这个注解，则退出
            if (dbTable == null) {
                System.out.println("No DBTable annotation in class " + className);
                continue;
            }
            //获取DBTable注解定义的表名
            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<>();
            StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
            //遍历该类的成员变量
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                //获取成员变量的全部注解
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    continue;
                }
                //根据对应类型生成，对应的sql
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sqlInteger = (SQLInteger) anns[0];
                    if (sqlInteger.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlInteger.name();
                    }
                    columnDefs.add(columnName + " INT" + getContraints(sqlInteger.containts()));
                }

                if (anns[0] instanceof SQLString) {
                    SQLString sqlString = (SQLString) anns[0];

                    if (sqlString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sqlString.value() + ")" + getContraints(sqlString.containts()));
                }
                if (anns[0] instanceof SQLBoolean) {
                    SQLBoolean sqlString = (SQLBoolean) anns[0];

                    if (sqlString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlString.name();
                    }
                    columnDefs.add(columnName + " CHAR(1)" + getContraints(sqlString.containts()));
                }
            }

            for (String columnDef : columnDefs) {
                createCommand.append("\n\t" + columnDef + ",");
            }
            String tableCreate = createCommand.substring(0, createCommand.length() - 1);
            tableCreate += ");";
            System.out.println("table sql for " + tableName + " is :\n+" + tableCreate);
        }

    }

    //获取字段的约束限定
    private static String getContraints(Containts containts) {
        String con = "";
        if (!containts.allowNull()) {
            con += " NOT NULL";
        }
        if (containts.primaryKey()) {
            con += " PRIMARY KEY";
        }
        if (containts.unique()) {
            con += " UNIQUE";
        }
        return con;
    }

    public static void main(String[] args) {
        try {
            generator(new String[]{"cn.hdj.annotations.SQLGenenator.Entity"});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
