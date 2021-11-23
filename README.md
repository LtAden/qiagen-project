## Resource Desctiption
This application can be used to calculate how much money will company have after paying their ZUS and PIT taxes. It can be used bt making API calls using Postman or some other applications.

## Endpoits
Application features two endpoints.

``` GET recent ``` Displays 5 most recent calculations. Initially populated with nulls, which are gradually replaced as new calculations are made. 

``` GET calculate/{income} ``` performs a calculation according to predefined formula on provided income. Upon sending a request, a result value is returned, and income-result pair is added to the list of recent calculations.

### Path parameter
Path parameter for ```calculate``` endpoint, income, accepts doubles as values. It also can handle integers.

## Request Examples
Here are some examples of using calculate endpoint.

```calculate/5000.00``` - this line will return value of ``` 2669.82 ```
You can obtain exactly the same result using ```calculate/5000```.

```calculate/-1250.23``` - this will return ``` -2630.41 ```. In case of incomes equal to 0, or lower than 0, only ZUS part is subtracted from income.

Using ```recent ``` will return a JSON of last 5 calculated examples. In this case: ``` [
{"income":-1250.23,"eat":-2630.41}, 
{"income":5000.0,"eat":2669.82}, 
{"income":5000.0,"eat":2669.82}, 
null, 
null] ```

