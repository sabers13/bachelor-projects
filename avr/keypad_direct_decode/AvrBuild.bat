@ECHO OFF
del "c:\folder\uni\micro\key\key.map"
del "c:\folder\uni\micro\key\labels.tmp"
"C:\Program Files (x86)\Atmel\AVR Tools\AvrAssembler2\avrasm2.exe" -S "c:\folder\uni\micro\key\labels.tmp" -fI  -o "c:\folder\uni\micro\key\key.hex" -d "c:\folder\uni\micro\key\key.obj" -e "c:\folder\uni\micro\key\key.eep" -m "c:\folder\uni\micro\key\key.map" -W+ie   "C:\Folder\uni\micro\key\key.asm"
