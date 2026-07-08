// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

  TalonFX motor1 = new TalonFX(1);
  TalonFX motor2 = new TalonFX(2);
  XboxController controller = new XboxController(0);

  Timer autoTimer = new Timer();
  boolean autoForward = true;

  boolean motor2On = false;
  boolean lastB = false;
  Timer motor2Timer = new Timer();

  @Override
  public void autonomousInit() {
    autoTimer.restart();
  }

  @Override
  public void autonomousPeriodic() {
    if (autoTimer.hasElapsed(3)) {
      autoForward = !autoForward;
      autoTimer.restart();
    }
    motor1.set(autoForward ? 0.5 : -0.5);
    motor2.set(autoForward ? 0.5 : -0.5);
  }

  @Override
  public void teleopPeriodic() {
    motor1.set(controller.getAButton() ? 0.5 : 0);

    boolean b = controller.getBButton();
    if (b && !lastB) {
      motor2On = !motor2On;
      motor2Timer.restart();
    }
    lastB = b;

    if (motor2On && motor2Timer.hasElapsed(10)) {
      motor2On = false;
    }

    motor2.set(motor2On ? 0.5 : 0);
    SmartDashboard.putBoolean("Motor2 On", motor2On);
  }
}