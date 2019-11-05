# ZavrsniRadAndroidApp
//STILL IN DEVELOPMENT 

This is final project for college assignment in form of Android application and my second personal project in Android.

This App is used to track people healthy habbits such as their workouts, steps during day, their height, weight and other measurements, so they can
keep track of their progress in fitness journey. 
Also this app have different role for fitness coaches. It allows coaches to store list of clients and keep track of their individual
workouts and progress. Also coaches can make calendar events so they can keep track of their next appointments with client.

App is using Google Firebase and Firestore for user registration aswell as storing user data such as their workouts, measurements and so on.
Also data is stored locally on device so app can be used in offline mode. 

App is developed on MVVM arhictecture using Room library to save data on device and javaRX library to fetch data from database on background thread.
For calendar integration in app, app is using Google Calendar API to display or create events for users who selected coach role during registration.
Dagger2 is used for dependency injection. 
