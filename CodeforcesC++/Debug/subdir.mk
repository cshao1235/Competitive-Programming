################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../Codeforces489E.cpp \
../Codeforces599A.cpp \
../Codeforces599B.cpp \
../Codeforces607B.cpp \
../Codeforces611B.cpp \
../Codeforces616D.cpp \
../Codeforces621C.cpp \
../Codeforces622A.cpp \
../Codeforces622B.cpp \
../Codeforces628B.cpp \
../Codeforces652B.cpp \
../Codeforces660C.cpp \
../Codeforces702A.cpp 

OBJS += \
./Codeforces489E.o \
./Codeforces599A.o \
./Codeforces599B.o \
./Codeforces607B.o \
./Codeforces611B.o \
./Codeforces616D.o \
./Codeforces621C.o \
./Codeforces622A.o \
./Codeforces622B.o \
./Codeforces628B.o \
./Codeforces652B.o \
./Codeforces660C.o \
./Codeforces702A.o 

CPP_DEPS += \
./Codeforces489E.d \
./Codeforces599A.d \
./Codeforces599B.d \
./Codeforces607B.d \
./Codeforces611B.d \
./Codeforces616D.d \
./Codeforces621C.d \
./Codeforces622A.d \
./Codeforces622B.d \
./Codeforces628B.d \
./Codeforces652B.d \
./Codeforces660C.d \
./Codeforces702A.d 


# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


