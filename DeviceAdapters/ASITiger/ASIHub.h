///////////////////////////////////////////////////////////////////////////////
// FILE:          ASIHub.h
// PROJECT:       Micro-Manager
// SUBSYSTEM:     DeviceAdapters
//-----------------------------------------------------------------------------
// DESCRIPTION:   ASI serial communication class (generic "hub")
//
// COPYRIGHT:     Applied Scientific Instrumentation, Eugene OR
//
// LICENSE:       This file is distributed under the BSD license.
//
//                This file is distributed in the hope that it will be useful,
//                but WITHOUT ANY WARRANTY; without even the implied warranty
//                of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
//
//                IN NO EVENT SHALL THE COPYRIGHT OWNER OR
//                CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
//                INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES.
//
// AUTHOR:        Jon Daniels (jon@asiimaging.com) 09/2013
//
// BASED ON:      ASIStage.h
//

#ifndef _ASIHub_H_
#define _ASIHub_H_

#include "ASIDevice.h"
#include "../../MMDevice/MMDevice.h"
#include "../../MMDevice/DeviceBase.h"
#include <string>

using namespace std;

////////////////////////////////////////////////////////////////
// *********** generic ASI comm class *************************
// implements a "hub" device with communication abilities
// also acts like a device itself
////////////////////////////////////////////////////////////////

class ASIHub : public HubBase<ASIHub>, public ASIDevice
{
public:
	ASIHub();
	~ASIHub() { }

	// Property handlers
	int OnPort(MM::PropertyBase* pProp, MM::ActionType eAct);

	// Communication base functions
   int ClearComPort();

   // SendCommand doesn't look for response
	int SendCommand(const char *command);
   int SendCommand(const string &command) { return SendCommand(command.c_str()); }

   // QueryCommand also gets the response (optional 2nd parameter is the response's termination string) (optional 3rd parameter is delay between sending and reading response)
   int QueryCommand(const char *command, const char *replyTerminator, const long delayMs); // all variants call this
   int QueryCommand(const char *command) { return QueryCommand(command, g_SerialTerminatorDefault, (long)0); }
   int QueryCommand(const string &command) { return QueryCommand(command.c_str(), g_SerialTerminatorDefault, (long)0); }
   int QueryCommand(const string &command, const string &replyTerminator) { return QueryCommand(command.c_str(), replyTerminator.c_str(), (long)0); }
   int QueryCommand(const char *command, const long delayMs) { return QueryCommand(command, g_SerialTerminatorDefault, delayMs); }
   int QueryCommand(const string &command, const long delayMs) { return QueryCommand(command.c_str(), g_SerialTerminatorDefault, delayMs); }
   int QueryCommand(const string &command, const string &replyTerminator, const long delayMs) { return QueryCommand(command.c_str(), replyTerminator.c_str(), delayMs); }

   // QueryCommandVerify gets the response and makes sure the first characters match expectedReplyPrefix
   int QueryCommandVerify(const char *command, const char *expectedReplyPrefix, const char *replyTerminator, const long delayMs); // all variants call this
   int QueryCommandVerify(const char *command, const char *expectedReplyPrefix)
      { return QueryCommandVerify(command, expectedReplyPrefix, g_SerialTerminatorDefault, (long)0); }
   int QueryCommandVerify(const string &command, const string &expectedReplyPrefix)
      { return QueryCommandVerify(command.c_str(), expectedReplyPrefix.c_str(), g_SerialTerminatorDefault, (long)0); }
   int QueryCommandVerify(const string &command, const string &expectedReplyPrefix, const string &replyTerminator)
      { return QueryCommandVerify(command.c_str(), expectedReplyPrefix.c_str(), replyTerminator.c_str(), (long)0); }
   int QueryCommandVerify(const char *command, const char *expectedReplyPrefix, const long delayMs)
      { return QueryCommandVerify(command, expectedReplyPrefix, g_SerialTerminatorDefault, delayMs); }
   int QueryCommandVerify(const string &command, const string &expectedReplyPrefix, const long delayMs)
      { return QueryCommandVerify(command.c_str(), expectedReplyPrefix.c_str(), g_SerialTerminatorDefault, delayMs); }
   int QueryCommandVerify(const string &command, const string &expectedReplyPrefix, const string &replyTerminator, const long delayMs)
      { return QueryCommandVerify(command.c_str(), expectedReplyPrefix.c_str(), replyTerminator.c_str(), delayMs); }

   // accessing serial commands and answers
   string LastSerialAnswer() const { return serialAnswer_; } // use with caution!; crashes to access something that doesn't exist!
   string LastSerialCommand() const { return serialCommand_; }
   void SetLastSerialAnswer(string s) { serialAnswer_ = s; }  // used to parse subsets of full answer for commands like PZINFO using "Split" functions

	// Interpreting serial response
	int ParseAnswerAfterEquals(double &val);  // finds next number after equals sign and returns as float
	int ParseAnswerAfterEquals(long &val);  // finds next number after equals sign and returns as long int
	int ParseAnswerAfterEquals(unsigned int &val);  // finds next number after equals sign and returns as long int
   int ParseAnswerAfterColon(double &val);  // finds next number after colon and returns as float
   int ParseAnswerAfterColon(long &val);  // finds next number after colon and returns as long int
	int ParseAnswerAfterPosition(unsigned int pos, double &val);  // finds next number after character position specified and returns as float
	int ParseAnswerAfterPosition(unsigned int pos, long &val);    // finds next number after character position specified and returns as long int
   int ParseAnswerAfterPosition(unsigned int pos, unsigned int &val);    // finds next number after character position specified and returns as unsigned int
   int ParseAnswerAfterPosition2(double &val);  // finds next number after character position 2 and returns as float
	int ParseAnswerAfterPosition2(long &val);    // finds next number after character position 2 and returns as long int
	int ParseAnswerAfterPosition2(unsigned int &val);    // finds next number after character position 2 and returns as unsigned int
   int ParseAnswerAfterPosition3(double &val);  // finds next number after character position 3 and returns as float
   int ParseAnswerAfterPosition3(long &val);    // finds next number after character position 3 and returns as long int
   int ParseAnswerAfterPosition3(unsigned int &val);    // finds next number after character position 3 and returns as unsigned int
   int GetAnswerCharAtPosition(unsigned int pos, char &val);  // returns the character at specified position, a safer version of LastSerialAnswer().at(pos)
   int GetAnswerCharAtPosition3(char &val);                   // returns the character at position 3, a safer version of LastSerialAnswer().at(3)

   vector<string> SplitAnswerOnDelim(string delim) const;  // splits answer on arbitrary delimeter list (any of included characters will split)
	vector<string> SplitAnswerOnCR() const { return SplitAnswerOnDelim("\r"); }
   vector<string> SplitAnswerOnSpace() const { return SplitAnswerOnDelim(" "); }

   // function to grab all the build info from BU X command
   int GetBuildInfo(const string addressLetter, build_info_type &build);

   // look to see if particular define is present
   bool IsDefinePresent(const build_info_type build, const string defineToLookFor);

   // action/property handlers
   int OnSerialTerminator           (MM::PropertyBase* pProp, MM::ActionType eAct);
   int OnSerialCommand              (MM::PropertyBase* pProp, MM::ActionType eAct);
   int OnSerialCommandRepeatDuration(MM::PropertyBase* pProp, MM::ActionType eAct);
   int OnSerialCommandRepeatPeriod  (MM::PropertyBase* pProp, MM::ActionType eAct);
   int OnSerialCommandOnlySendChanged(MM::PropertyBase* pProp, MM::ActionType eAct);

protected:
   string port_;         // port to use for communication

private:
	int ParseErrorReply() const;
	string EscapeControlCharacters(const string v ) const;
	string UnescapeControlCharacters(const string v0 ) const;
	vector<char> ConvertStringVector2CharVector(const vector<string> v) const;
	vector<int> ConvertStringVector2IntVector(const vector<string> v) const;

   string serialAnswer_;      // the last answer received
   string serialCommand_;     // the last command sent, or can be set for calling commands without args
   string serialTerminator_;  // only used when parsing command sent via OnSerialCommand action handler
   long serialRepeatDuration_; // for how long total time the command is repeatedly sent
   long serialRepeatPeriod_;  // how often in ms the command is sent
   bool serialOnlySendChanged_;        // if true the serial command is only sent when it has changed
};



#endif //_ASIHub_H_
