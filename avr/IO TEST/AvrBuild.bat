@ECHO OFF
del "c:\folder\uni\micro\io test\io test.map"
del "c:\folder\uni\micro\io test\labels.tmp"
"C:\Program Files (x86)\Atmel\AVR Tools\AvrAssembler2\avrasm2.exe" -S "c:\folder\uni\micro\io test\labels.tmp" -fI  -o "c:\folder\uni\micro\io test\io test.hex" -d "c:\folder\uni\micro\io test\io test.obj" -e "c:\folder\uni\micro\io test\io test.eep" -m "c:\folder\uni\micro\io test\io test.map" -W+ie   "C:\Folder\uni\micro\IO TEST\IO TEST.asm"
