package com.pdn.spark.sql.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import scala.Int;

/**
 * @author pdn
 */
@Data
@AllArgsConstructor
public class Person {
    private String name;
    private Int age;
}
