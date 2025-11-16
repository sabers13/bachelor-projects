@ECHO OFF
del "c:\folder\uni\micro\7seg\7seg.map"
del "c:\folder\uni\micro\7seg\labels.tmp"
"C:\Program Files (x86)\Atmel\AVR Tools\AvrAssembler2\avrasm2.exe" -S "c:\folder\uni\micro\7seg\labels.tmp" -fI  -o "c:\folder\uni\micro\7seg\7seg.hex" -d "c:\folder\uni\micro\7seg\7seg.obj" -e "c:\folder\uni\micro\7seg\7seg.eep" -m "c:\folder\uni\micro\7seg\7seg.map" -W+ie   "C:\Folder\uni\micro\7seg\7seg.asm"
