#!/bin/bash

unamestr="$(uname)"

if [[ "$unamestr" == "Linux" ]]; then
  drun_path=$(find . -type d -iname drun)
  cp -Rv "$drun_path" /usr/local/bin/
  chmod -R +x /usr/local/bin/drun
  touch ~/.bash_profile
  echo 'export PATH="$PATH:/usr/local/bin/drun"' | tee -a ~/.bash_profile
  source ~/.bash_profile
elif [[ "$unamestr" == "Darwin" ]]; then
  drun_path=$(find . -type d -iname drun)
  cp -Rv "$drun_path" /usr/local/bin/
  chmod -R +x /usr/local/bin/drun
  mkdir -p /etc/paths.d && echo /usr/local/bin/drun | tee /etc/paths.d/drun
else
  echo "Unsupported platform!!"; exit 1; 
fi
