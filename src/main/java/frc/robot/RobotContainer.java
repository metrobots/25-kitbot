// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.drivetrain.DriveSubsystem;
import frc.robot.subsystems.drivetrain.commands.DriveCommand;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.intake.commands.IntakeCommand;
import frc.robot.subsystems.intake.commands.ShootCommand;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

    // Replace with CommandPS4Controller or CommandJoystick if needed
    private final CommandXboxController primaryController =
        new CommandXboxController(OperatorConstants.driverControllerPort);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        configureButtonBindings();
    }

    /**
     * Driving: left analog stick controls speed (front to back), right analog stick
     * controls rotation (right and left).
     */
    private void configureButtonBindings() {
        driveSubsystem.setDefaultCommand(new DriveCommand(driveSubsystem,
            () -> - primaryController.getLeftY(), () -> - primaryController.getLeftX()));
        primaryController.b().whileTrue(new ShootCommand(intakeSubsystem));
        primaryController.x().whileTrue(new IntakeCommand(intakeSubsystem));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An example command will be run in autonomous
        return Autos.exampleAuto(m_exampleSubsystem);
    }
}
