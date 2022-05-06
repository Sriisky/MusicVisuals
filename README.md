# Music Visualiser Project

Name: Sara Egan, Milosz Lewandowski, Sabrina Boc

Student Number: C20353056, C20355901, C20394813

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
Our assignment is a audio visual representation of the song Andromeda by Gorillaz.

# Instructions
Our assignment uses switch cases. We have 3 visuals in total and you use the 1-3 keys to cycle through our visuals. The first visual we let run though the first trimester of the song, and the second visual is for the chorus. The the third visual for the final section of the song. Once you run the program the first case visual and song will automatically start. 
Press space bar to pause and resume the music. 

# How it works
When the program is initially run, the music file "andromeda.mp3" starts playing and our case 1 visual begins to render on the screen. This is done by utilising the packages  ``` dd.minim.AudioBuffer``` and ```dff.minim.AudioInput``` to process the mp3 file containing the music.

For the visuals, built-in methods from ```processing.core.PApplet``` was utilised to create objects to be displayed on the canvas.  
In our first case visual, we utilised the ```pushMatrix();``` and ```popMatrix()```. These two methods were used to create a 3D-effect for when objects were drawn on the canvas. It allowed layering of visual objects on screen, and so we could translate a visual to move behind and forwards of a stationary visual, i.e.

```Java
	pushMatrix();
	lights();
	stroke(random(0, 255), 255, 255);
	fill(0);
	translate(200, 200, wave * 200);
	rotate(wave);
	box(daddy);
	popMatrix();
```


# What I am most proud of in the assignment
Our proudest moment was creating code that resembles the feeling of the music. There is a real out of space melody to the song so we decided to recreate the feeling of falling through space with our 1st visual. We had many errors in the initial development of our star warp background but after many failed attempts we made a successful version where there is a perception of the stars coming from the middle of the screen.


This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube]https://youtu.be/pksVNBjTAwE

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

