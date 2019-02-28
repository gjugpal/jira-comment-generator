package com.geek.jira;

import org.apache.commons.lang3.StringUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.util.Set;
import java.util.TreeSet;


public class Comment {

        private static final String NEW_LINE = "\n";
        private static final StringBuilder jiraComment = new StringBuilder();
        private static final Set<String> resultSet = new TreeSet<>();
        private static int numTestsPassed;
        private static int numTestsFailed;

        private Comment(){

        }

        protected static String generate(final ITestContext results) {
            numTestsPassed = results.getPassedTests().size();
            numTestsFailed = results.getFailedTests().size();
            results.getPassedTests().getAllResults().forEach((r -> addToResultSet("(/)", r)));
            results.getFailedTests().getAllResults().forEach((r -> addToResultSet("(x)", r)));
            generateComment();
            return jiraComment.toString();
        }

        private static void addToResultSet(final String img, ITestResult testResult) {
            String testName = StringUtils.substringAfter(testResult.getInstanceName(), "jira.").concat(".").concat(testResult.getName());

            if (!resultSet.contains(img + " " + testName)) {
                resultSet.add(String.format("|%s|%s|", testName, img));
            }
        }

        private static void generateComment() {
            jiraComment.append(
                    "{panel:title=Test Automation | borderColor=#581845 |titleBGColor=#581845 | borderWidth=3px | bgColor=#FFF| borderStyle=solid | titleColor=white}\n" +
                            "bq. The following automated tests were executed;");

            jiraComment.append(NEW_LINE);
            jiraComment.append(getStats());
            jiraComment.append(NEW_LINE);
            jiraComment.append(NEW_LINE);
            jiraComment.append("||Test Script||Status||");
            jiraComment.append(NEW_LINE);
            resultSet.forEach((t -> jiraComment.append(t).append(NEW_LINE)));
            jiraComment.append("{panel}");
        }

        private static String getStats() {
            return String.format("h5. Executed:%d   Passed:%d   Failed:%s", resultSet.size(), numTestsPassed, numTestsFailed);
        }

}
