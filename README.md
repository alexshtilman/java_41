Write an application-game “ThreadsRace” 
Each thread should run loop of distance iterations. Threads are running whole distance independently each on other.  At each iteration the thread prints out its own number (regular println) and sleeps a random amount of milliseconds [2-5]  The sleeping time range should be the same for all threads. 
Thread that is finishing the loop the first is the winner. 
 
The application should take a number of threads (3 – 10) and a distance (100 – 3500) from the console input/output.  
At the end of a game there should be printed out the following message 
“Congratulations to thread #X (winner)” where X - is the thread-winner number.

``Hint: Apply “photo-finish” rather than measuring time``
