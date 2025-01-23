AnimeListAPP
OverView:
  - This app allows us to view the top animes
  - A list is shown with the noof episodes, rating title and image
  - Onclick we move to the new page showing title,trailervideo,synopsis,rating,episodes,genres
  - navigation component is used with the safe args to tranfer data between two fragments
  - used uiState for the ui responsiveness
  - liveData,coroutines,mvvm architecture
Limitations:
  - the api response doesnt contain the main cast to show them
  - the video player is of webview in which all the links are given of youtube is the best way todo in short time
  - if its a url we can use exoplayer for playing the video
  - two api calls are given ,but the 1st api call is giving the all the details,so to just reduce the api call count the just used the same data in the detail page
    
