# GenerateMonthlyPayslip

GenerateMonthlyPayslip is a java application for calculating net monthly income after tax deductions

## Installation

```bash
./gradlew clean build
cd app/build/distributions
unzip GenerateMonthlyPayslip.zip
cd GenerateMonthlyPayslip/bin
```

## Run

```bash
./GenerateMonthlyPayslip "Mary Song" 60000 "Australia/New Zealand"
```
## Sample Output

```bash
Monthly Payslip for: Mary Song
Gross Monthly Income: $5000.00
Monthly Income Tax: $500.00
Net Monthly Income: $4500.00
```

## Assumptions
Precision of two decimal places for all the output values

Please make sure that java is installed in your system before installation

