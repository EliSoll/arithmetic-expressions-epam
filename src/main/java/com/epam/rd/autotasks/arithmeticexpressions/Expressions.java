package com.epam.rd.autotasks.arithmeticexpressions;

import java.util.Arrays;
import java.util.StringJoiner;

public class Expressions {
    private static Expression val;
    public static int value;



    public Expressions(int value) {
        Expressions.value = value;
    }



    public static Variable var(String name, int value) {

        return new Variable(name, value) {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                return name;
            }
        };
    }



    public static Expression val(int value) {

          val = new Expression() {

            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                StringBuilder sb = new StringBuilder();
                if(value<0) {
                    sb.append("(").append(value).append(")");
                }
                else {
                    sb.append(value);
                }

                return sb.toString();
            }
        };
        return val;
    }

    public static Expression sum(Expression... members) {

        val = new Expression() {
            @Override
            public int evaluate() {
                    int sum = 0;
                    for (Expression i: members
                    ) {
                        sum += i.evaluate();
                    }
                    return sum;
                }


            @Override
            public String toExpressionString() {
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                for (int i = 0; i < members.length - 1; i++) {
                    sb.append(members[i].toExpressionString()).append(" + ");
                }
                sb.append(members[members.length - 1].toExpressionString()).append(")");
                return sb.toString();

            }
        };
        return val;
    }

            public static Expression product(Expression... members) {

                val = new Expression() {
                    @Override
                    public int evaluate(){
                        int prod = 1;
                        for (Expression i: members
                        ) {
                            prod *= i.evaluate();
                        }
                        return prod;
                    }

                    @Override
                    public String toExpressionString() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("(");
                        for (int i = 0; i < members.length - 1; i++) {
                            sb.append(members[i].toExpressionString()).append(" * ");
                        }
                        sb.append(members[members.length - 1].toExpressionString()).append(")");
                        return sb.toString();

                    }
                };
                return val;
            }

            public static Expression difference(Expression minuend, Expression subtrahend) {

                val = new Expression() {
                    @Override
                    public int evaluate() {
                        return minuend.evaluate() - subtrahend.evaluate();
                    }


                    @Override
                    public String toExpressionString() {
                        return "(" + minuend.toExpressionString() + " - " + subtrahend.toExpressionString() + ")";

                    }
                };
                return val;
            }

            public static Expression fraction(Expression dividend, Expression divisor) {
                val = new Expression() {
                    @Override
                    public int evaluate() {
                        return dividend.evaluate() / divisor.evaluate();
                    }


                    @Override
                    public String toExpressionString() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("(").append(dividend.toExpressionString()).append(" / ").append(divisor.toExpressionString()).append(")");
                        return sb.toString();

                    }
                };
                return val;
            }

        }

