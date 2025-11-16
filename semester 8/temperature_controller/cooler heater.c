#include <stdio.h>

int main() {
    int state = 1;
    int temperature = 25;
    int coolerState, heaterState, CRS;

    while (1) {
        switch (state) {
            case 1:
                if (temperature < 15)
                    state = 3;
                else if (temperature > 35)
                    state = 2;
                else {
                    printf("both cooler and heater are off\n");
                    scanf("%d", &temperature);
                }
                break;
            case 2:
                coolerState = 1;
                while (1) {
                    switch (coolerState) {
                        case 1:
                            CRS = 4;
                            if (temperature > 40)
                                coolerState = 2;
                            else if (temperature < 25) {
                                state = 1;
                                break;
                            }
                            else {
                                printf("cooler is on and heater is off and CRC is %d\n", CRS);
                                scanf("%d", &temperature);
                            }
                            break;
                        case 2:
                            CRS = 6;
                            if (temperature < 35)
                                coolerState = 1;
                            else if (temperature > 45)
                                coolerState = 3;
                            else {
                                printf("cooler is on and heater is off and CRC is %d\n", CRS);
                                scanf("%d", &temperature);
                            }
                            break;
                        case 3:
                            CRS = 8;
                            if (temperature < 40)
                                coolerState = 2;
                            else {
                                printf("cooler is on and heater is off and CRC is %d\n", CRS);
                                scanf("%d", &temperature);
                            }
                            break;
                    }
                    if (coolerState == 1 && temperature < 25)
            break;
                }
                break;
            case 3:
                heaterState = 1;
                while (1) {
                    switch (heaterState) {
                        case 1:
                            if (temperature > 30) {
                                state = 1;
                                break;
                            }
                            else if (temperature < 10)
                                heaterState = 2;
                            else {
                                printf("heater is on and in low mode and cooler is off\n");
                                scanf("%d", &temperature);
                            }
                            break;
                        case 2:
                            if (temperature > 15)
                                heaterState = 1;
                            else {
                                printf("heater is on and in high mode and cooler is off\n");
                                scanf("%d", &temperature);
                            }
                            break;
                    }
                    if (heaterState == 1 && temperature > 30)
            break;
                }
                break;
        }
    }

    return 0;
}
