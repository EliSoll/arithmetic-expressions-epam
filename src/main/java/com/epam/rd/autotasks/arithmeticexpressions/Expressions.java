package com.epam.rd.autotasks.arithmeticexpressions;

import java.util.Arrays;
import java.util.StringJoiner;

public class Expressions {
    private Variable var;
    private static Variable[] variables;
    private static Expression[] membersNew;
    private static int membersCount = 0;
    private static  int variablesCount = 0;
    private static Expression val;
    public static int value;

    public Expressions(int value) {
        Expressions.value = value;
    }



    public static Variable var(String name, int value) {
        Variable var = new Variable(name, value) {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                return name;
            }
        };

        return var;
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
                else if(value>=0) {
                    sb.append(value);
                }

                return sb.toString();
            }
        };
        return val;
    }

    public static Expression sum(Expression... members) {
        membersNew = new Expression[members.length];
        int j = 0;
        for (int i = 0; i < members.length ; i++) {
            membersNew[j++] = members[i];
        }
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
                    sb.append(members[i].toExpressionString() + " + ");
                }
                sb.append(members[members.length-1].toExpressionString() + (")"));
                return sb.toString();

            }
        };
        return val;
    }

            public static Expression product(Expression... members) {

                membersNew = new Expression[members.length];
                int j = 0;
                for (int i = 0; i < members.length ; i++) {
                    membersNew[j++] = members[i];
                }
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
                            sb.append(members[i].toExpressionString() + " * ");
                        }
                        sb.append(members[members.length-1].toExpressionString() + (")"));
                        return sb.toString();

                    }
                };
                return val;
            }

            public static Expression difference(Expression minuend, Expression subtrahend) {

                val = new Expression() {
                    @Override
                    public int evaluate() {
                        int dif = minuend.evaluate() - subtrahend.evaluate();
                        return dif;
                    }


                    @Override
                    public String toExpressionString() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("(" + minuend.toExpressionString() + " - " + subtrahend.toExpressionString() + ")");
                        return sb.toString();

                    }
                };
                return val;
            }

            public static Expression fraction(Expression dividend, Expression divisor) {
                val = new Expression() {
                    @Override
                    public int evaluate() {
                        int frac = dividend.evaluate() / divisor.evaluate();
                        return frac;
                    }


                    @Override
                    public String toExpressionString() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("(" + dividend.toExpressionString() + " / " + divisor.toExpressionString() + ")");
                        return sb.toString();

                    }
                };
                return val;
            }

        }

