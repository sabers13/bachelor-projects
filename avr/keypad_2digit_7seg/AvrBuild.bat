@ECHO OFF
del "d:\micro\keypad\keypad.map"
del "d:\micro\keypad\labels.tmp"
"C:\Program Files (x86)\Atmel\AVR Tools\AvrAssembler2\avrasm2.exe" -S "d:\micro\keypad\labels.tmp" -fI  -o "d:\micro\keypad\keypad.hex" -d "d:\micro\keypad\keypad.obj" -e "d:\micro\keypad\keypad.eep" -m "d:\micro\keypad\keypad.map" -W+ie   "D:\micro\KEYPAD\KEYPAD.asm"
