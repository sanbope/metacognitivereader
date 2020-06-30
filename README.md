This is for read the text of the changes (syntactic.txt pragmatic.txt and semantic.txt) for make the changes of the text inside the app easyer. 
It converts the .text to variables.

#####ex:

_syntactic.txt:_

hola mundo!
Example: this is an example#
Correction: this is a correction#
Note: if u want
u can put a note here,
and then into the app appears a button "note"#

_opened with this software:_


var uses = [
'hola mundo!',
];

var examples = [
'this is an example',
];

var corrections = [
'this is a correction',
];

var notes = [
'if u want'+
'u can put a note here,'+
'and then into the app appears a button "note"',
];


#####if u dont want to put any thing here u can put null.

ex:
hola mundo!
Example: this is an example#
Correction: null#
Note: null#


#####if u want to put more than 1 item u have to divide'em with "DIVPREGUNTAS"

ex:

hola mundo 1!
Example: this is an example#
Correction: null#
Note: null#
DIVPREGUNTAS
hola mundo 2!
Example: this is an example#
Correction: null#
Note: null#
DIVPREGUNTAS
hola mundo 3!
Example: this is an example#
Correction: null#
Note: null#


the "#" marks the end of the item, if u put # anywere the things next to it going to be ignored.

#IF U DONT WANT TO PUT AN EXAMPLE, CORRECTION OR NOTE PLEASE USE "null" IF U DONT, IT GONNA CRASH.