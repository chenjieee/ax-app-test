Scenario: query
Given default login to ax-app
When navigate to IMAGEAPP
When query with basic metadata 1,SAMPLE*
When view by index 0
Then force taking screenshot