package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        List<MethodSignature.Argument> arguments = new ArrayList<>();
        String accessModifier = "";
        String returnType = "";
        String methodName = "";
        StringTokenizer stringTokenizer = new StringTokenizer(signatureString, "(");
        if(stringTokenizer.countTokens() == 2) {
            StringTokenizer stringTokenizerFirst = new StringTokenizer(stringTokenizer.nextElement().toString(), " ");
            if(stringTokenizerFirst.countTokens() == 3) {
                accessModifier = stringTokenizerFirst.nextToken();
            }
            returnType = stringTokenizerFirst.nextToken();
            methodName = stringTokenizerFirst.nextToken();

        }
        StringTokenizer stringTokenizerArguments = new StringTokenizer(stringTokenizer.nextElement().toString(), " ,)");
        while(stringTokenizerArguments.hasMoreElements()) {
            if(stringTokenizerArguments.countTokens() >= 2) {
                arguments.add(new MethodSignature.Argument(stringTokenizerArguments.nextToken(), stringTokenizerArguments.nextToken()));
            }
        }
        MethodSignature methodSignature = new MethodSignature(methodName, arguments);
        if(!accessModifier.isEmpty()) methodSignature.setAccessModifier(accessModifier);
        methodSignature.setReturnType(returnType);
        return methodSignature;
    }
}
