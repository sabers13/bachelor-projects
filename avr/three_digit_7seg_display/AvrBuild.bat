@ECHO OFF
del "c:\folder\uni\micro\ex10\ex10.map"
del "c:\folder\uni\micro\ex10\labels.tmp"
"C:\Program Files (x86)\Atmel\AVR Tools\AvrAssembler2\avrasm2.exe" -S "c:\folder\uni\micro\ex10\labels.tmp" -fI  -o "c:\folder\uni\micro\ex10\ex10.hex" -d "c:\folder\uni\micro\ex10\ex10.obj" -e "c:\folder\uni\micro\ex10\ex10.eep" -m "c:\folder\uni\micro\ex10\ex10.map" -W+ie   "C:\Folder\uni\micro\ex10\ex10.asm"
