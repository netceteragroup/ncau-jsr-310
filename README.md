
The initial discussion about tricks with Java's calendar classes leads
me to three other exercises to bring up here:

1. Create a function that returns a boolean whether today (i.e. the
moment in time when the function is called) is the last day of the month
or not. The function might be called within the whole time interval of a
day, i.e. from [midnight...midnight). (I was asked that recently for a
function in Tcl.)

2. Create a function that returns the current age of a person in years
(integer only) where the birth date of that person is given. Some
additional requirements:
- The function can be called any time and should always return the
correct age.
- The person in question might live anywhere on earth. The server where
the calculation is done is located in Zurich, Switzerland.

3. If we would not use Gregorian calendars and java.util.Date but
javax.startrek.util.Stardate, would problem no. 2 be simpler to solve in
Java? (You might refer to http://starchive.cs.umanitoba.ca/?stardates/
and http://steve.pugh.net/fleet/stardate.html for definitions and
calculations with stardates.)

