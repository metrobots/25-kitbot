package frc.robot.subsystems.intake;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
    private final SparkMax motor = new SparkMax(IntakeConstants.INTAKE_MOTOR, MotorType.kBrushless);

    public IntakeSubsystem() {}

    public void drive(double speed) {
        this.motor.set(speed);
    }

    public void stop() {
        this.motor.stopMotor();
    }
}
