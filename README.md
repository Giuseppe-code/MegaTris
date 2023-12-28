<h1>Overview -28/11/2022 </h1>
<h3>Better of Tic Tac Toe</h3>
<p>Megatris is a Android game created and implemented by @GiuseppeVinci04 and me in the last year of high school as our personal project.<br>
    All is playable with a friend or with a not-so-intelligent bot.<br>
  The game was realized in Java on Android Studio for Android phone,
   is currently in the <a href="https://play.google.com/store/apps/details?id=it.ggworld.megatris">Play Store</a> and is monetize with AdMob.<br>
  We developed the idea, logo, and all activities, images (all in .svg), and classes..<br>
</p>

<h1>Disclaimer</h1>
<p>
  This project could be improved. My friend and I had limited knowledge at the time and many things could be changed, such as the name of the activity, 
  the class management, the choose of the language, the OOP, the value static, the comment wrote in Italian, the absence of github... <br>
  <h3>**However, we want to publish this project as a point of reference and a warning for future projects.**</h3>
</p>
<h1>Tutorial of the game</h1>
<p>
  The game uses 9 little tris (TrisSecondary in the project) to create a large big Tris (TrisPrimary in the project). 
Each cell of the little tris is equivalent to a cell of the big tris. If your opponent plays in the cell of the little Tris, 
you must play in the corresponding tris of the Megatris. Whoever gets three in a row in the big tris wins.
</p>

<h1>Tutorial of the Project</h1>
<p>
  TrisPrimary is the large tris while TrisSecondary is the little, 
  TrisPrimary is an object used by the class TrisSecondary for all types of functions, such as the player's turn, 
  victory or defeat of the player, taking of the little tris, and the management of the sequence.

  
  Sequence, the player must play in an order chosen by the previous move. So, we created an ArrayList that memorizes the number of the tris 
  and the number of the cells where the player played.<br>
  Admob, we insert the public unit test<br>
  TrisSecondaryBot, this extends TrisSecondary and creates a random list of moves. With a few controls, it decides the better move to play.<br>
  ActivityHelp, these are activities that, with images and text, help the player understand the game.
  
</p>
<h1>Versions and Total Size</h1>
<p>
  TargetSDK: 33<br>
  Android Version: 8.0+<br>
  Size of the app: 5MB<br>
</p>

<h1>Conclusion</h1>
<p>If you wish, you can improve this project for personal use! 
**However, we highly discourage you from sharing it.**
**That's all! Good Game!**</p>
