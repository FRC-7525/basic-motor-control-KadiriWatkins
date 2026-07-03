# Assignment

Set up two motors (I recommend using Krakens). Then:

In autonomous:

1. Have both motors run forward for 3 seconds, backwards for 3 seconds, etc., for the entire autonomous period.

In teleop:

1. Have motor 1 turn on when the A button on an Xbox Controller is held down. It should stop when the button is not held down.
2. Have motor 2 toggle whenever the B button is pressed. If the button is pressed once, the motor turns on. When it's pressed again, it's turned off. Etc.
3. Put the state of the toggle on SmartDashboard.
4. If motor 2 is toggled on for more than 10 seconds, it should automatically be toggled off.

There are no automated tests for this assignment, so test each of these cases manually before submitting.