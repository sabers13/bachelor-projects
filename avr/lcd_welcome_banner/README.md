# lcd_welcome_banner

AVR-based **16×2 character LCD** demo implemented in C and simulated with Proteus.  
The firmware displays an animated “WELCOME” banner followed by a scrolling “AVR / microcontroller” message.

## Overview

- Target MCU: **ATmega16** (or compatible AVR)
- Display: **16×2 HD44780-compatible character LCD**
- Data/control interface: configured via `lcd.h` and inline assembly (`__lcd_port=0x1B`)
- Toolchain: **CodeVisionAVR / AVR-GCC** with `<mega16.h>`, `<lcd.h>`, and `<delay.h>`
- Simulation: **Proteus** project (`LCD.pdsprj`)

The program demonstrates basic LCD initialization, positioning text on specific rows/columns, and simple text animations using delays.

## Files

```text
firmware/
  lcd_welcome_banner.c        # Main C source file (renamed from cv7.c)
  lcd_welcome_banner.cproj    # AVR project file (renamed from cv7.cproj)
  lcd_welcome_banner.atsln    # Atmel Studio solution file (renamed from cv7.atsln)

simulation/
  LCD.pdsprj                  # Proteus simulation project (MCU + 16×2 LCD)
```

## Firmware Behavior

The core logic uses a static character array:

```c
char text1[] = {'*','W','E','L','C','O','M','E','*'};
```

Main animation steps:

1. **WELCOME banner build-up (row 0)**  
   - The LCD is initialized with `lcd_init(16)`.  
   - A loop prints each character of `text1` one by one starting at column 4 of the first row:
     - `lcd_gotoxy(i, 0);`
     - `lcd_putchar(text1[i - 4]);`
     - `delay_ms(200);`
   - This creates a left-to-right reveal of `*WELCOME*` near the center of the first line.
   - The display is then cleared with `lcd_clear()`.

2. **Scrolling “AVR / microcontroller” message**  
   - A second loop runs with `j` from 0 to 8:
     - On row 0, `"AVR"` is printed starting at column `j + 5`.
     - On row 1, `"microcontroller"` is printed starting at column `j`.
     - After each update, the code waits `150 ms` and then clears the display.
   - This produces a simple scrolling effect where the words move horizontally across the screen on both rows.
   - A short `delay_ms(200)` separates animation cycles.

3. **Continuous loop**  
   - Both animations repeat indefinitely inside the main `while(1)` loop, alternately showing the WELCOME banner and the scrolling AVR/microcontroller text.

## Hardware / Simulation Setup

- **LCD module**
  - 16×2 HD44780-compatible display connected to the MCU pins defined in `lcd.h` and by the `__lcd_port=0x1B` directive.
  - Data and control lines wired according to the CodeVisionAVR LCD library configuration.
- **Microcontroller**
  - ATmega16 with clock configuration set in the project options (e.g. 8 MHz internal oscillator).
- **Proteus schematic**
  - Contains the ATmega16 and the 16×2 LCD wired per the same pinout as specified in the firmware.
  - The compiled HEX file from `lcd_welcome_banner.c` is loaded into the MCU component.

## Educational Points

- Initializing and driving a **character LCD** with a high-level library (`lcd.h`).
- Positioning text using `lcd_gotoxy(column, row)` and printing characters/strings with `lcd_putchar` and `lcd_putsf`.
- Creating basic **text animations** using simple loops and fixed delays.
- Understanding how to keep the LCD output readable while repeatedly clearing and rewriting content.
